package LessonsJAVA;

public class LessonAboutThis {
	public static void main(String [] args) {
		Bob bob = new Bob();
		bob.setId(32);
		
		int id = bob.getId();
		System.out.println(id);
		for(int i=0; i<=id; i++) {
			
		}

	}
	
	
}
class Bob{
	int id;
	
	public void setId(int id) {
		this.id=id;
	}
	/*
	 * this. указывает на переменную обьекта. 
	 * переменная в параметрах(в скобочках) метода, доступна\видна лишь для метода.
	 * без слова this. у нас будет так:
	 * int id;
	 * public void setId(int id) {
	 *		id=id;
	 *	}
	 * java видит одинаковые переемнные. И берет ближайшую, то беж ту которая в методе.
	 * и присваивает переменной метода = значение перемннной метода.
	 * 
	 * с помощю this. мы указываем что одна из переменных являеться переменной обекта.
	 * public void setId(int id) {
	 *		this.id=id;
	 *	}
	 * и уже ей присваеваем, то есть той переменной которая нам нужна, значение переменной метода.
	 *
	 * 
	 */
	public int getId() {
		return id;
	}
	

}

