package ru.kazimir.bortnik;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import ru.kazimir.bortnik.impl.MathematicalServiceImpl;

public class MathematicalServiceTest {
    @Test
    public void checkOnNullData() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        mathematicalService.sum(null);
    }

    @Test
    public void ifVoidDataReturnToNullValue() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        String data = "";
        Integer value = mathematicalService.sum(data);
        assert value == 0;

    }
    @Test
    public void  dataThatDoesNotMatchThePattern() {
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        String data = "43[564";
        Integer value = mathematicalService.sum(data);
        assert value == 0;

    }

}
