import org.junit.Assert.assertEquals
import org.junit.Test

class IntCodeTest {
    @Test fun `test data`(){
        val data = updatedData()
        assertEquals("2,0,0,0,99", IntCode(data("1,0,0,0,99")).process())
        assertEquals("2,3,0,6,99", IntCode(data("2,3,0,3,99")).process())
        assertEquals("2,4,4,5,99,9801", IntCode(data("2,4,4,5,99,0")).process())
        assertEquals("30,1,1,4,2,5,6,0,99", IntCode(data("1,1,1,4,99,5,6,0,99")).process())
    }
}

