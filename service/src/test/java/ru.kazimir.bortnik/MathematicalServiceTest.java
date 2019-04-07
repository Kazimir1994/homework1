package ru.kazimir.bortnik;


import org.junit.Test;
import ru.kazimir.bortnik.exception.NullData;
import ru.kazimir.bortnik.impl.MathematicalServiceImpl;

public class MathematicalServiceTest {
    @Test(expected = NullData.class)
    public void checkOnNullData() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        mathematicalService.add(null);
    }

    @Test
    public void ifVoidDataReturnToNullValue() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        String data = "";
        Integer value = mathematicalService.add(data);
        assert value == 0;

    }

    @Test
    public void dataThatDoesNotMatchThePattern() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        String data = "43[564";
        Integer value = mathematicalService.add(data);
        assert value == 0;
    }

    @Test
    public void checkOnFractionalPart() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        String data = "4.3:3.4:";
        Integer value = mathematicalService.add(data);
        assert value == 0;
    }
}
