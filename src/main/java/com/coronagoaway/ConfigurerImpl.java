package com.coronagoaway;

public class ConfigurerImpl implements Configurer {

//    @Override
//    public Class<? extends T> configure(Class<T> t) {
//        Field[] fields = t.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            InjectedProperty annotation = field.getAnnotation(InjectedProperty.class);
//            if (annotation != null) {
//                if (annotation.value().isEmpty()) {
//                    String path = ClassLoader.getSystemClassLoader().getResource("recommendation.properties").getPath();
//                    Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
//                    Map<String, String> mapOfValues = lines.map(x -> x.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
//                    String value = mapOfValues.get(field);
//                    field.setAccessible(true);
//                    field.set(t, value);
//                } else {
//                    field.setAccessible(true);
//                    field.set(t, annotation.value());
//                }
//            }
//        }
//        return t;
//    }
}

