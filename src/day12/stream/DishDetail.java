package day12.stream;

public class DishDetail {

	private final String dishName;
	private final String type;

	public DishDetail(Dish dish) {
		this.dishName = dish.getName();
		this.type = dish.getType().getDesc(); //getType 까지만 하면 MEAT, FISH, OTHER 까지만 걸린다.
	}

	public String getDishName() {
		return dishName;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "DishDetail{" +
				"dishName='" + dishName + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
