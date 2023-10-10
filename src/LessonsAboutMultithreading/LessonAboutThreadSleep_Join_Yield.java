package LessonsAboutMultithreading;

/*
 * С помощью этих методов класса Thread можно повлиять на планировщик потоков:
 * 
 * sleep(int mls) - это метод который успыляет/останавливает поток на определенное время указанное в аргументах.
 * Время указанное в аргументах указываеться в миллисекундах
 * так же у метода есть перегружаенная версия:
 * sleep(int mls, int n) - второй параметр это добавочное время в котором мы хотим что бы поток находился во сне.
 * (Диапозон от 0 - 999999)
 * 
 * С этим методом есть пару важных вещей:
 * 1) Если система загруженна тогда время пребывания во сне у потока может быть больше чем указанно в аргументах.
 * Если наоборот, система не так сильно и загруженна тогда время сна потока будет почти равно тому что в аргументах
 * 2) Если выполнить прерывание потока во время его сна( во время работы sleep()) тогда выскочит исключение InterruptedException e
 * 
 * join() - заставляет текущий поток ждать пока выполниться поток который вызвал метод.
 * То есть если мы в потоке main создаем поток А и на потоке А вызываем метод join(), 
 * тогда main поток останавливаеться и ждет пока поток А выполнит свою работу.
 * То есть по сути метод join() можно описать как "Подождите меня".
 * 
 * Есть еще один вариант написания этого метода:
 * join(int mls) указываем время в милисикундах на которое должен остановиться текущий поток, но есть два важных замечания:
 * 1) Если мы укажем текущему потоку ждать 4 секунды(join(4000)), а сам вызвавший метод поток закончит свое выполнение через 2 секунды, тогда
 * текущий поток не будет ждать еще лишние 2 секунды, а сразу продолжит свое выполнение.
 * 2) Если все будет наоборот и мы например укажем 2 секунды(join(2000)), а сам вызвавший метод поток закончит свое выполнение через 4 секунды, тогда
 * текущий поток продолжит свое выполнение через 2 секунды. В общем он будет ждать столько сколько указали.
 * 3) Выполнение этого метода зависит от операционной системы, потому java не гарантирует что текущий поток будет ждать ровно указанное время.
 * 
 * yield() - это статический метод который переводит текущий поток в состояние Runnable, тем самым уступая место выполнения/время выполнения/мощность процессора другим.
 * Кому именно перейдет мощность процессора и время на выполнение решит планировщик потоков.
 * В целом этот метод по сути досрочно обрывает выполнение потока и его выделенный отрезок времени.
 * Потому следующее действие после этого метода в этом потоке будет выполняться с полным свежим отрезком времени.
 * То есть если впереди достаточно крупная задача, которую лучше не обрывать,
 * можно вызвать этот метод перед ней оборвать оставшийся отрезок времени, и уже потом с полным/целым/свежим отрезком времени выполнить задачу без прерываний.
 * Таким образом можно оптимизировать некоторые процессы.
 * 
 * Так же на планировщик потоков может влиять и setPriority(), но тут все понятно.
 * 
 */
public class LessonAboutThreadSleep_Join_Yield {

	public static void main(String[] args) {
		Thread ta1 = new Thread(new ArcherTest());
		ta1.start();
		try {
			ta1.join();//Текущий поток в нашем случае это main и он будет ждать пока поток ta1 выполниться
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
		
	}

}
class ArcherTest extends Thread {

	public void run() {
		System.out.println("Стрела полетела");
		for(int i = 0; i<=5; i++) {
			System.out.println(i);
			try {		
				Thread.sleep(1000);//Усыпляем/останавливаем поток на 1 секунду
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Стрела долетела");

	}
}