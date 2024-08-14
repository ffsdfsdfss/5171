import java.util.logging.Level;
import java.util.logging.Logger;

public class Airplane {
    private static final Logger LOGGER = Logger.getLogger(Airplane.class.getName());

    private Integer airplaneID;
    private String airplaneModel;
    private Integer businessSitsNumber;
    private Integer economySitsNumber;
    private Integer crewSitsNumber;

    private Double maxPayload;  // 最大载重量（单位：吨）
    private Double range;       // 最大航程（单位：公里）

    public Airplane(Integer airplaneID, String airplaneModel, Integer businessSitsNumber, Integer economySitsNumber, Integer crewSitsNumber) {
        setAirplaneID(airplaneID);
        setAirplaneModel(airplaneModel);
        setBusinessSitsNumber(businessSitsNumber);
        setEconomySitsNumber(economySitsNumber);
        setCrewSitsNumber(crewSitsNumber);
    }

    public Airplane(Integer airplaneID, String airplaneModel, Integer businessSitsNumber, Integer economySitsNumber, Integer crewSitsNumber, Double maxPayload, Double range) {
        this(airplaneID, airplaneModel, businessSitsNumber, economySitsNumber, crewSitsNumber);
        setMaxPayload(maxPayload);
        setRange(range);
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(Integer airplaneID) {
        if (airplaneID == null) {
            LOGGER.log(Level.SEVERE, "Invalid Airplane ID: null value provided.");
            throw new IllegalArgumentException("airplaneID cannot be null.");
        }
        if (airplaneID > 0) {
            this.airplaneID = airplaneID;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid Airplane ID: {0} - must be positive.", airplaneID);
            throw new IllegalArgumentException("Airplane ID must be positive.");
        }
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        if (airplaneModel != null && !airplaneModel.isEmpty()) {
            this.airplaneModel = airplaneModel;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid Airplane Model: null or empty value provided.");
            throw new IllegalArgumentException("Airplane model cannot be null or empty.");
        }
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(Integer businessSitsNumber) {
        if (businessSitsNumber == null) {
            LOGGER.log(Level.SEVERE, "Invalid BusinessSitsNumber: null value provided.");
            throw new IllegalArgumentException("BusinessSitsNumber cannot be null.");
        }
        if (businessSitsNumber >= 0 && businessSitsNumber <= 20) {
            this.businessSitsNumber = businessSitsNumber;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid BusinessSitsNumber: {0} - must be between 0 and 20.", businessSitsNumber);
            throw new IllegalArgumentException("Business sits number must be between 0 and 20.");
        }
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(Integer economySitsNumber) {
        if (economySitsNumber == null) {
            LOGGER.log(Level.SEVERE, "Invalid EconomySitsNumber: null value provided.");
            throw new IllegalArgumentException("EconomySitsNumber cannot be null.");
        }
        if (economySitsNumber >= 0 && economySitsNumber <= 270) {
            this.economySitsNumber = economySitsNumber;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid EconomySitsNumber: {0} - must be between 0 and 270.", economySitsNumber);
            throw new IllegalArgumentException("Economy sits number must be between 0 and 270.");
        }
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(Integer crewSitsNumber) {
        if (crewSitsNumber == null) {
            LOGGER.log(Level.SEVERE, "Invalid CrewSitsNumber: null value provided.");
            throw new IllegalArgumentException("CrewSitsNumber cannot be null.");
        }
        if (crewSitsNumber >= 1 && crewSitsNumber <= 10) {
            this.crewSitsNumber = crewSitsNumber;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid CrewSitsNumber: {0} - must be between 1 and 10.", crewSitsNumber);
            throw new IllegalArgumentException("Crew sits number must be between 1 and 10.");
        }
    }

    public Double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(Double maxPayload) {
        if (maxPayload != null && maxPayload > 0) {
            this.maxPayload = maxPayload;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid MaxPayload: {0} - must be positive.", maxPayload);
            throw new IllegalArgumentException("Max payload must be positive.");
        }
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        if (range != null && range > 0) {
            this.range = range;
        } else {
            LOGGER.log(Level.SEVERE, "Invalid Range: {0} - must be positive.", range);
            throw new IllegalArgumentException("Range must be positive.");
        }
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "model='" + getAirplaneModel() + "', " +
                "business sits=" + getBusinessSitsNumber() + ", " +
                "economy sits=" + getEconomySitsNumber() + ", " +
                "crew sits=" + getCrewSitsNumber() +
                (maxPayload != null ? ", max payload=" + maxPayload + " tons" : "") +
                (range != null ? ", range=" + range + " km" : "") +
                '}';
    }

    public static Airplane getAirPlaneInfo(int airplane_id) {
        // TODO Auto-generated method stub
        return null;
    }
}
