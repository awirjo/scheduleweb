package sr.unasat.scheduleweb.entities;

public class MenuDTO {

    private int id;

    private String breakfast;

    private String lunch;

    private String dinner;

    private String special_meals;

    private String description;

    public MenuDTO(){}

    public MenuDTO(int id, String breakfast, String lunch, String dinner, String special_meals, String description) {
        this.id = id;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.special_meals = special_meals;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSpecial_meals() {
        return special_meals;
    }

    public void setSpecial_meals(String special_meals) {
        this.special_meals = special_meals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", breakfast='" + breakfast + '\'' +
                ", lunch='" + lunch + '\'' +
                ", dinner='" + dinner + '\'' +
                ", special_meals='" + special_meals + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
