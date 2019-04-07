package ru.kazimir.bortnik.impl;

import ru.kazimir.bortnik.MathematicalService;
import ru.kazimir.bortnik.exception.NullData;

import java.util.stream.Stream;

public class MathematicalServiceImpl implements MathematicalService {
    private static MathematicalServiceImpl instance;

    private MathematicalServiceImpl() {
    }

    public static MathematicalServiceImpl getInstance() {
        if (instance == null) {
            instance = new MathematicalServiceImpl();
        }
        return instance;
    }

    private static final String PATTERN_SPLIT = "([:,|\n])";

    @Override
    public int add(String numbers) {
        if (numbers != null) {
            return Stream.of(numbers.split(PATTERN_SPLIT))
                    .filter(s -> s.matches("\\d+"))
                    .map(Integer::valueOf).reduce(0, (element1, element2) -> element1 + element2);
        }
        throw new NullData();
    }
}
