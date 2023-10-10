package LessonsAboutMultithreading;
/*
 * Эта тема после синхронизации!
 * Иногда требуеться что бы при взаемодействии потоков между собой они могли б как то извещять друг друга об своих действиях и реагировать на них.
 * Для этого в Java есть три метода, все они находяться в классе Object и имеют модификатор final.
 * (final для метода означает что его нельзя переопределить)
 * Все эти методы можно использовать ТОЛЬКО в блоке synchronized, или в синхронизированном методе.
 * 1) wait() - освобождает монитор обьекта и переводит текущий поток в состояние ожидания, пока другой поток не вызовит notify()
 * 2) notify() - продолжает работу того потока у которого был ранее вызван wait()
 * 3) notifyAll() - продолжает работу ВСЕХ потоков у которых был вызван ранее wait()
 *  
 */
public class LessonAbout_wait_notify_notifayAll {

	public static void main(String[] args) {
		
		Arrows a = new Arrows();
		
		Thread ta1 = new Thread(new Archer(a));
		Thread ta2 = new Thread(new Archer(a));
		
		ta1.start();
		ta2.start();
		
		try {
			ta1.join();
			ta2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

class Arrows{//Наши стрелы
	int arrow = 5;
}

class Archer implements Runnable{
	Arrows arrows;
	
	public Archer(Arrows arrows) {
		this.arrows=arrows;
	}

	@Override
	public void run() {
		
		while(arrows.arrow>0) {//Цикл выполняеться пока стрелы не закончаться
			
			synchronized (arrows) {
				System.out.println(Thread.currentThread().getName()+" Стреляю");
				arrows.arrow--;//Отнимаем стрелу
				if((arrows.arrow%2) == 0) {//Если стрел четное количество 
					System.out.println(Thread.currentThread().getName()+" Стрельнул Жду, стрел: "+arrows.arrow);
					
				/*
				 * Для примера строки с notify() и wait() можно закоментировать, 
				 * Что будет мы увидим что потоки не будут ждать друг друга, 
				 * а просто один поток выстреляет все стрелы сам, и когда он закончит он спокойно выйдет и уступит монитор(блок синхронизаци) второму потоку.
				 * Второй поток уже будет в while, ведь заходили то они в один момент когда стрел было больше 0, и встал перед блоком синхронизации в ожидание
				 * и когда ему уступили стрел нет!
				 * Он отнял от 0 единицу, вышло -1
				 * И вышел из цикла.
				 * А notify(), wait() заставляют их ждать и чередоваться между друг другом
				 * 
				 */
				try {
					arrows.notify();//Обьект будит спящий поток, которому вызвали wait()
					arrows.wait();//Монитор обьекта освобождаеться и поток переходит в состояние ожидания
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				}else {
					System.out.println(Thread.currentThread().getName()+" Стрельнул Бужу, стрел: "+arrows.arrow);
					//Для примера с notify() и wait() строки можно закоментировать:
					try {
						arrows.notify();//Обьект будит спящий поток, которому вызвали wait()
						arrows.wait();//Монитор обьекта освобождаеться и поток переходит в состояние ожидания
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//
				}
				
				if(arrows.arrow==0) {//Если стрел останетсья 0
					arrows.notifyAll();//У нас по итогу останеться ждать один поток, если потоков будет не 2 а больше то и ждать останутсья тоже больше
									   //Потому этим методом мы заупскаем их всех.
									   //Можэно удалить для примера
				}
				
			}
			
		}
		
		
	}
	
	
}