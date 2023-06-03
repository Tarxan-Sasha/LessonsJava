package LessonsAboutStreamsIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* ZipOutputStream и ZipInputStream созданы для чтения и записи zip архивов, они наследуются от FilterOutputStream и FilterInputStream.
 * В целом, суть идет больше об упаковке(помещении) файлов в архив и распоковке(вынимания) файлов из архива.
 * 
 * ZipOutputStream - записыват/упоковует/всовует файлы в архив.
 * ZipInputStream - читает/распоковует/вынимает файлы из архива.
 * 
 * У них есть вспомогающий класс ZipEntry, который отвечает за элемент(файл) в архиве.
 * После работы с обьектом ZipEntry, его нудно закрывать методом closeEntry().
 * Только после метода closeEntry(), можно начинать работу со следующим элементом архива. 
 * 
 * У ZipOutputStream и ZipInputStream есть доп методы, на ряду с их методами которые пришли кним от их родителей(InputStream OutputStream)
 * ZipOutputStream:
 * 1)putNextEntry(ZipEntry entry) - ложит/архивирует/упоковует файл(обьект ZipEntry) в архив.
 * 2)closeEntry() - закрывает и прекращает работу с текущим обьектом ZipEntry, только после него можно преступать к записи/упаковке следующего элемента
 * 
 * ZipInputStream:
 * 1)getNextEntry() - вынимает/распоковует файл(в лице обьекта ZipEntry) из архива.
 * 2)closeEntry() - закрывает и прекращает работу с текущим обьектом ZipEntry, только после него можно преступать к чтению/выниманию/распоковке следующего элемента
 *
 */
public class LessonAboutZipInputStreamAndZipOutputStream {

	public static void main(String[] args) {
		File file = new File("src/LessonsAboutStreamsIO/Games.txt");
		//конструкторы ZipOutputStream
		try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("src/LessonsAboutStreamsIO/TestZip.zip"));//Принимает обьект потока FileOutputStream в котором находиться путь к архиву,
																													//архив будет создан если не будет найден
			
				FileInputStream fis = new FileInputStream(file)){//обьект FileInputStream который будет считывать файл Games.txt
			
			//Архивируем файл Games.txt
			ZipEntry entry = new ZipEntry("Games.txt");//Передаем имя архивируемого файла, а именно Games.txt
			zos.putNextEntry(entry);//Влаживаем/всовуем/упаковуем/архивируем файл в архив.
			/*
			 * Теперь у нас есть файл отдельно Games.txt, и отдельно он же в архиве.
			 * и мы хотим не только перекинуть файл в архив, но и информацию с него тоже передать в новый заархивированный файл
			 * Без этого он будет пуст.
			 */
			byte [] array = new byte[fis.available()];//Создаем масив с размером всех доступных для чтения байтов файла.
													//(Примичание: метод available() возвращает количество байтов которых можно прочитать в потоке, 
													// например слово StarCraft это 9 байтов, потому available() вернет 9)
			fis.read(array);//считываем байты из файла в массив байтов, заполняя его полностью(если это возможно)
			zos.write(array);//записываем уже в заархивированный файл содержание массива 
			zos.flush();//выталкиваем все содержимое принудительно, как бы удостовериваемся что поток чист.
			zos.closeEntry();//закрываем работу с этим элементом, после этого можно начинать архивировать следующий файл.

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////
		//конструткоры ZipInputStream
		try(ZipInputStream zis = new ZipInputStream(new FileInputStream("src/LessonsAboutStreamsIO/TestZip.zip"))){//Принимает обьект потока FileInputStream в котором находиться путь к архиву,
																												   //будет выбрашено исключение если не будет найден архив.
			ZipEntry entry = zis.getNextEntry();//передаем файл из архива в обьект ZipEntry
			String name = entry.getName();//получаем имя файла
			
			FileOutputStream fos = new FileOutputStream("src/LessonsAboutStreamsIO/"+name);//Создаем поток который считывает указанный файл, если файла нет тогда он создаться 
																						  //Файлов может быть в архиве много, потому мы имя файла просто доабвляем...но сейчас файл один
			int i;
			while( (i=zis.read()) != -1) {//читаем как обычно по байту, read() верент -1 если счиытвание будет невозможно, так что пока ш не равна -1 файл будет считыватсья
				fos.write(i);//И сразу же записываем считаный байт из архивируемого файла в новый свежесозданынй НЕархивируемый файл
			}
			fos.flush();//выталкиваем все содержимое принудительно, как бы удостовериваемся что поток чист.
			zis.closeEntry();//закрываем работу с этим элементом, после этого можно начинать разархивировать следующий файл.
			fos.close();//Закрываем поток FileOutputStream
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}