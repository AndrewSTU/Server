package sk.stuba.fei.mtmp.server.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalculusRequest {
    private Double angle;
    private Double velocity;
}
