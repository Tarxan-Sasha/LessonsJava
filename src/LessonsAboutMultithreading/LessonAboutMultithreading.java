package LessonsAboutMultithreading;

/*
 * Многопоточность - одно из свойств java.
 * 
 * С начала про многозадачность, она бывает двух типов:
 * Многозадачность на основе процесов - это когда выполняеться больше чем один процесс. 
 * Процесс - это крупная задача, работа одной программы/приложения на компютере.
 * То есть Многозадачность на основе процессов - это когда выполняеться больше чем одна программа.
 * Каждый процесс занимает свое адресное пространство и переключение между процессами (и в целом даже связь между ними) это сложное и затратное занятие.
 * Один процесс может иметь несколько потоков, и менять их количество во время своей работы.
 * 
 * Многозадачность на основе потоков - это когда программа может выполнять сразу несколько действий/задач, например:
 * Воспроизводить музыку и изменять под неё цвет фона приложения.
 * Эти действия/задачи можно назвать потоками выполнения, и именно на их основе реализована многозадачность в java.
 * (Потому она наверно и называетсья многопоточность - типо много потоков выполнения)
 * Поток выполнения - это выполнение кода то есть инструкции процесса.
 * Потоки выполенения занимают одно адресное пространство, их легче связывать и переключаться между ними
 * Многопоточность позволяет уменьшить время простоя программы выполняя сразу два действия в один момент, а не выполняя одно действие затем другое.
 * 
 * Слово поток в многопоточности java - означает две вещи, но по сути разные:
 * 1) Поток выполнения
 * 2) Обьект класса Thread (Thread - это по сути главный класс потоков)
 * 
 * Когда программа запускаетсья она автоматичски создает и начинает выполнять свой главный поток(main).
 * Главный/основной поток это по сути и есть сама программа, пока работает main работает и программа.
 * main - это и родитель других потоков, в нем зарождаються другие дочерние потоки.
 * Все потоки процесса/приложения вместе используют:
 * 1) одни и те же переменные класса и статические переменные
 * 2) одну и ту же кучу (динамически рапределяемая память)
 * 3) одни и те же ресурсы для работы.
 * Но каждый из них имеет свой Стек.
 * 
 * За работу потоков отвечают ядра процессора, чем больше ядер тем больше и быстрее будет выполняться потоки.
 * Каждое ядро процессора берет на себя один поток, потому количество ядер напрямую влияет на эффективность многопоточности.
 * Но это не значит что одноядерному процессору жопа и использовать многопточность он не сможет, нет.
 * Одноядерному процессору будет трудно, но он постараеться имитировать работу потоков словно они работают как при многоядерном процессоре - то есть паралельно.
 * Он будет в рандомном месте останваливать один поток, сохранять его данные, потом начинать второй поток, потом снов в рандомном месте остановиться сохранит данные
 * и начнет выполнение первого потока на том моменте на котором останвился, потом снова так же и со вторым и так до самого конца.
 * Такой способ называеться - псевдо-параллелизмом
 * 
 * Что бы создать поток нужно (кратко):
 * 1) Создать обьект класса который наследует класс Thread или имплементирует интерфейс Runnable (второй вариант более предпочтительный)
 * 2) переопределяем метод run()
 * 3) и запускаем у обьекта метод start()
 * 
 * В целом в работе с многопточностью есть и минусы:
 * На некоторых платформах дополнительные потоки могут замедлить роботу приложения, если конечно важна его производительность.
 * Каждый поток имеет свои локальные переменные, свой стек в памяти. А потому чем больше потоков тем больше стеков, значит больше памяти используеться.
 * В некоторых системах вообще есть предел количества используемых потоков, 
 * но если такого ограничения в системе нет, всегда есть ограничение в максимальной скорости процессора
 * 	
 * Хорошая статья на хабре по многопоточности: https://habr.com/ru/articles/164487/
 * 
 */
public class LessonAboutMultithreading {

	public static void main(String[] args) {
		TestThread1 tt = new TestThread1();
		int [] array = {0,1,2,3,4};
		tt.start();
		for(int i : array) {
			System.out.println(i);
		}
		System.out.println(tt);
		
	}

}
class TestThread1 extends Thread{
	char [] symbols = {'A','B','C','D','E'};
	public void run(){
		for(char i : symbols) {
			System.out.println(i);
		}
	}
}