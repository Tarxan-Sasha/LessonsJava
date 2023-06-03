package LessonsAboutStreamsIO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;

/*
 * FilterInputStream и FilterOutputStream - это классы потоков которые полностью повторяют InputStream и OutputStream.
 * Они расширяют их функциональность, и имеют дочерние классы такие как BufferedInputStream и BufferedOutputStream, DataInputStream и DataOutputStream
 * Они принимают в конструктор другой поток и переопределяют все методы InputStream и OutputStream под этот другой поток. 
 * Каардинально, да и в целом нечего, это в методах не меняет.
 * Просто из-за наследования, их дочерние классы обьязаны также принимать другой поток в своих конструкторах.
 * Также дочерние классы имеют уже удобные переопределенные стандартные методы под второй поток, из-за своих родителей FilterInputStream и FilterOutputStream
 * И им не нужно переопределять ВСЕ методы под второй поток, а лишь те что им нужно.
 * 
 * FilterInputStream и FilterOutputStream - классы больше "помошники", они редко используються индивидуально.
 * Их потомки добавлют доп. функционал для уже обычных потоков, а FilterInputStream и FilterOutputStream делают "грязную работу"
 * 
 */
public class LessonAboutFilterInputStreamAndFilterOutputStream {

	public static void main(String[] args) {
		byte [] array= {0,1};
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		
		// Конструкторы FilterInputStream и FilterOutputStream
		FilterOutputStream fos = new FilterOutputStream(baos);//Просто принимает поток класса который наследуетсья от OutputStream
		FilterInputStream fis = new BufferedInputStream(bais);//Изза того что конструтор FilterInputStream защищен protected
															  //мы не можем создать его обьект явно, но через его наследников можем.
														      //Просто принимает поток класса который наследуетсья от InputStream

	}

}

