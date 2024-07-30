package dp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Segment {

    private String rate;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;

}
