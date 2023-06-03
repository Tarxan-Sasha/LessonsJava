package LessonsAboutCollections;

import java.util.Objects;

public class Demons implements Comparable<Demons> {
	int power;
	String name;
	
	public Demons(int power, String name) {
		super();
		this.power = power;
		this.name = name;
	}

	public int getPower() {
		return power;
	}
	public String getname() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, power);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demons other = (Demons) obj;
		return Objects.equals(name, other.name) && power == other.power;
	}

	@Override
	public int compareTo(Demons o) {// с помощью этого метода мы задаем "естественную" сортировку для обьектов этого класса
		if(this.getPower() < o.getPower()) {
			return -1;
		}else {
			if(this.getPower() > o.getPower()) {
				return 1;
			}else {
				return 0;
			}
		}
		//return this.power - o.power;
		/*
		 * Мы берем один объект демона (this), силу этого демона и вычитаем из него силу дргугого демона (того, с которым сравниваем объект).
		 * Если сила первого демона больше, метод вернет int > 0.
		 * А значит, демон this > демона о.
		 * Если наоборот — сила второго демона (о) больше, значит метод вернет отрицательное число, а следовательно, о > this.
		 * Ну а если они равны, метод вернет 0.
		 */
	}

	@Override
	public String toString() {
		return "Demons [power=" + power + ", name=" + name + "]";
	}
	
	
}
