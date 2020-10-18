package extract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo {
	public static void main(String[] args) {
		String url = "https://englishfreetest.com/courses-tips-articles/english-tenses.html";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(20000).get();
			// lấy danh sách các thể <a> chứa bài viết từ kết quả trả về
			Elements lstArticles = doc.select("div.post-content h2 a");
			
			// khoi tao file
			File file = new File("C:\\Users\\admin\\Desktop\\test.html");
			FileWriter fw = new FileWriter(file);
			
			// ghi ra du lieu
			for (Element element : lstArticles) {
				// Link bài viết nằm trong thuộc tính href của thẻ <a>
				System.out.println("link:" + element.attr("href"));
				doc = Jsoup.connect(element.attr("href")).userAgent("Jsoup client").timeout(20000).get();
				// Lấy nội dung bài viết
				Elements article = doc.select("article.post");
				// Ở đây tôi cần nội dung bài viết dạng html nên không cần phân tích tiếp nữa
		//		System.out.println(article.get(0).html());
				// Do something
				// ............................
				// ............................
				// ............................
				
				fw.write(article.get(0).html());
				
				
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
