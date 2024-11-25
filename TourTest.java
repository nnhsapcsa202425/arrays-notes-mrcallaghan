
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * The test class TourTest.
 *
 * @author  gcschmit
 * @version 03jun2020
 */
public class TourTest
{
    /**
     * Default constructor for test class TourTest
     */
    public TourTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    // !!! how best to test that distance is updated propertly?

    @Test
    public void testDefaultConstructor()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        assertEquals(BigTenData.getCities().length, cityIndices.length);
        for(int i = 0; i < cityIndices.length; i++)
        {
            assertEquals(0, cityIndices[i]);
        }
    }

    @Test
    public void testCopyTour()
    {
        Tour tour1 = new Tour();
        int[] cityIndices = tour1.getCityIndices();
        int[] originalCityIndices = new int[cityIndices.length];
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
            originalCityIndices[i] = cityIndices[i];
        }
        tour1.updateDistance();
        double originalDistance = tour1.getDistance();

        Tour tour2 = Tour.copyTour(tour1);

        assertArrayEquals(tour1.getCityIndices(), tour2.getCityIndices(),
            "the new tour has different city indices than the specified tour");
        assertNotSame(tour1.getCityIndices(), tour2.getCityIndices(),
            "the new tour refers to the same array as the specified tour; was the reference copied?");
        assertEquals(tour1.getDistance(), tour2.getDistance());
        assertArrayEquals(originalCityIndices, tour1.getCityIndices(),
            "the copyTour method changed the specified Tour object");
        assertEquals(originalDistance, tour1.getDistance(),
            "the copyTour method changed the specified Tour object");
    }

    @Test
    public void testSwapRandTwo()
    {
        int randCount = 0;

        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
        }
        tour.updateDistance();

        for(int i = 0; i < 1000; i++)
        {
            Tour prevTour = Tour.copyTour(tour);
            int[] prevCityIndices = prevTour.getCityIndices();

            tour.swapRandTwo();

            assertEquals(0, cityIndices[0], "the element at index 0 should never be swapped");

            int index1 = 0, index2 = 0;

            for(int j = 0; j < cityIndices.length; j++)
            {
                if(cityIndices[j] != prevCityIndices[j])
                {
                    if(index1 == 0)
                    {
                        index1 = j;
                        randCount++;
                    }
                    else if(index2 == 0)
                    {
                        index2 = j;
                    }
                    else
                    {
                        fail("more than 2 elements were swapped");
                    }
                }
            }

            assertEquals(prevCityIndices[index1], cityIndices[index2]);
            assertEquals(prevCityIndices[index2], cityIndices[index1]);
        }

        assertTrue(randCount >= 800, "elements should be swapped a majority of the time");
    }

    @Test
    public void testPopulateWithCities()
    {
        double prevDistance = 0;
        int dupTourCount = 0;
        for(int i = 0; i < 1000; i++)
        {
            Tour tour = new Tour();
            tour.populateWithCities();
            int[] cityIndices = tour.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length));
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertNotEquals(0.0, tour.getDistance());
            if(tour.getDistance() == prevDistance)
            {
                dupTourCount++;
            }
            prevDistance = tour.getDistance();
        }

        assertTrue(dupTourCount < 5, "consecutive random tours should be very rare");

    }

    @Test
    public void testUpdateDistance()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
        }
        tour.updateDistance();
        double dist1 = tour.getDistance();
        assertEquals(5105, dist1, 5);
        tour.updateDistance();
        double dist2 = tour.getDistance();
        assertEquals(dist1, dist2, 1, "consecutive calls to updateDistance are not equal");

        int[] cityIndices2 = { 0, 1, 3, 5, 7, 9, 11, 13, 2, 4, 6, 8, 10, 12 };
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = cityIndices2[i];
        }
        tour.updateDistance();
        dist1 = tour.getDistance();
        assertEquals(6751, dist1, 5);
        tour.updateDistance();
        dist2 = tour.getDistance();
        assertEquals(dist1, dist2, 1, "consecutive calls to updateDistance are not equal");
    }

    @Test
    public void testMutate()
    {
        int mutateCount = 0;

        Tour tour = new Tour();
        tour.populateWithCities();

        for(int i = 0; i < 1000; i++)
        {
            Tour prevTour = Tour.copyTour(tour);
            tour.mutate();
            if(! Arrays.equals(prevTour.getCityIndices(), tour.getCityIndices()))
            {
                mutateCount++;
                double prevDistance = tour.getDistance();
                tour.updateDistance();
                assertEquals(prevDistance, tour.getDistance(), 0.01);
            }
        }

        assertEquals(TravelingStudent.mutationProbability, mutateCount/1000.0, 0.05,
            "the measured probability of mutation differs from the specified probability");
    }

    @Test
    public void testCrossOver()
    {
        Tour parentA;
        Tour parentB;
        do
        {
            parentA = new Tour();
            parentA.populateWithCities();
            parentB = new Tour();
            parentB.populateWithCities();
        }
        while(Arrays.equals(parentA.getCityIndices(), parentB.getCityIndices()));

        int[][] testIndexPairs = new int[][] { {1, 1}, {11, 11}, {7, 7} };

        for(int[] indexPair : testIndexPairs)
        {
            Tour child = parentA.crossOver(parentB, indexPair[0], indexPair[1]);
            int[] cityIndices = child.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                    "value " + j + " missing in child");
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertArrayEquals(cityIndices, parentA.getCityIndices(),
                "child expected to match parentA");
            assertNotEquals(0, child.getDistance(), "the child's distance must not be zero");

        }

        testIndexPairs = new int[][] { {1, 13} };
        for(int[] indexPair : testIndexPairs)
        {
            Tour child = parentA.crossOver(parentB, indexPair[0], indexPair[1]);
            int[] cityIndices = child.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                    "value " + j + " missing in child");
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertArrayEquals(cityIndices, parentB.getCityIndices(),
                "child expected to match parentB");

        }

        for(int x1 = 1; x1 < BigTenData.getCities().length - 2; x1++)
        {
            for(int x2 = x1; x2 < BigTenData.getCities().length; x2++)
            {
                Tour child = parentA.crossOver(parentB, x1, x2);
                int[] cityIndices = child.getCityIndices();
                for(int j = 0; j < BigTenData.getCities().length; j++)
                {
                    assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                        "value " + j + " missing in child");
                }

                assertEquals(0, cityIndices[0], "the first element must always be 0");
            }
        }
    }

    @Test
    public void testGetCities()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = cityIndices.length - i - 1;
        }
        tour.updateDistance();

        City[] expectedCities = BigTenData.getCities();
        City[] actualCities = tour.getCities();
        for(int i = 0; i < expectedCities.length; i++)
        {
            assertEquals(expectedCities[i], actualCities[expectedCities.length - i - 1],
                "the city at index " + i + " should be " + expectedCities[i]);
        }

        int[] randomTour = { 0, 1, 10, 13, 6, 8, 2, 7, 4, 11, 9, 5, 3, 12 };
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = randomTour[i];
        }
        tour.updateDistance();

        actualCities = tour.getCities();
        for(int i = 0; i < expectedCities.length; i++)
        {
            assertEquals(expectedCities[randomTour[i]], actualCities[i],
                "the city at index " + i + " should be " + expectedCities[randomTour[i]]);
        }
    }

    @Test
    public void testCompareTo()
    {
        Tour[] tours = new Tour[1000];
        for(int i = 0; i < tours.length; i++)
        {
            tours[i] = new Tour();
            tours[i].populateWithCities();
        }

        Arrays.sort(tours);

        double prevDistance = 0;
        for(int i = 0; i < tours.length; i++)
        {
            assertTrue(tours[i].getDistance() >= prevDistance, "tours incorrectly compared");
            prevDistance = tours[i].getDistance();
        }

        Tour equalTour = Tour.copyTour(tours[0]);
        assertEquals(0, equalTour.compareTo(tours[0]), "compared tours should be equal");
    }
}