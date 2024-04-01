package annotation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Data
@Slf4j
public class AnnoTest {
    public static void main(String[] args) {

        Class cls = AnnoTest.class;
        Annotation[] annotations = cls.getAnnotations();
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
//        PatData annotation = cls.getAnnotation(PatData.class);
//        boolean present = cls.isAnnotationPresent(Slf4j.class);
        log.info("annotations:{}", Arrays.toString(annotations));
        log.info("declaredAnnotations:{}",Arrays.toString(declaredAnnotations));
//        log.info("annotation:{}",annotation);
//        log.info("present:{}",present);
    }
}
