/*
 * Heap (Куча) - это область динамической памяти в которой храняться обьекты и JRE классы.
 * Создание  обьекта происходит в куче.
 * В этой обласи памяти работает Сброщик мусора - который освобождает память,
 * удаляя обьекты на которые никто не ссылаеться.
 * 
 * Stack (стек) - это область памяти которая существует пока существует метод.
 * Она работает по системе LIFO (последним пришел — первым вышел).
 * В ней хранятся переменные, ссылки на объекты и частичные результаты.
 * 
 */

package LessonsJAVA;

public class LessonHeapAndStack {
	int a=3;
	public static void main(String[] args) {
	 LessonHeapAndStack lessonHeapAndStack = new LessonHeapAndStack();
	 lessonHeapAndStack.a=4;
	 System.out.println(lessonHeapAndStack.a);
	 lessonHeapAndStack=null;
	 System.gc();
	 LessonHeapAndStack lessonHeapAndStack1 = new LessonHeapAndStack();
	 System.out.println(lessonHeapAndStack1.a);
	}
 }
