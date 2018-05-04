//***************
//***Daniel Rayo***
//***************
package model;


public class Location {
    private int id;
    private String locationName;
    private int distributionCapacity;
    public Location(){}
    
    public Location(int id, String loc, int dstrCapacity){
    this.id = id;
    this.locationName = loc;
    this.distributionCapacity = dstrCapacity;
    }
    public Location(String location, int distributionCapacity){
    this.distributionCapacity = distributionCapacity;
    this.locationName = location;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the distributionCapacity
     */
    public int getDistributionCapacity() {
        return distributionCapacity;
    }

    /**
     * @param distributionCapacity the distributionCapacity to set
     */
    public void setDistributionCapacity(int distributionCapacity) {
        this.distributionCapacity = distributionCapacity;
    }

   
}
