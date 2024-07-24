package Requests;

import lombok.Data;

@Data
public class TripRequestModel
{
    private tripEnum tripEnum;
    private int fromId;
    private int toId;
    private int departureId;
    private int arrivalId;
}
