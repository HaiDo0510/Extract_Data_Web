package extract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Chuong;
import model.TheLoaiTruyen;
import model.Truyen;

public class Demo1 {
	private static Document doc = null;
	private static Elements elements = null;

// truyền vào link và thẻ cần lấy nôi dung của trang web lấy ra nội dung
	public Elements getContentFromLink(String url, String tag) {
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {

			e.printStackTrace();
		}
		elements = doc.select(tag);
		return elements;
	}
	
	public void writeFileJson(TheLoaiTruyen tlt) {
		File_Writer f = new File_Writer();
		JSONObject obj = new JSONObject();
        obj.put("ten_the_loai_truyen", tlt.getTenTheLoai());
        obj.put("link_the_loai_truyen", tlt.getLinkTheLoai());
        JSONArray arr = new JSONArray();
        
        ArrayList<Truyen> truyenArrayList = tlt.getTruyen();    
        for (Truyen t:truyenArrayList ) {
        	JSONObject obj1 = new JSONObject();
        	obj1.put("ten_truyen", t.getTenTruyen());
        	obj1.put("link_truyen", t.getLinkTruyen());
        	JSONArray arr1 = new JSONArray();
        	
        	ArrayList<Chuong> chuongArrayList = t.getChuong();
        	for(Chuong c:chuongArrayList) {
        		JSONObject obj2 = new JSONObject();
            	obj2.put("ten_chuong", c.getTenChuong());
            	obj2.put("link_chuong", c.getLinkChuong());
            	arr1.add(obj2);
        	}
        	obj1.put("Chuong", arr1);
        	
        	arr.add(obj1);
        }
        obj.put("the_loai", arr); 
        
		f.writeFileJson("truyen.json", obj.toJSONString());
	}

	public static void main(String[] args) {
		String url = "https://webtruyen.com";
		String tag = "section.card-box div.categories a";
		String theLoaiTruyen;
		String linkTheLoaiTruyen;
		String tenTruyen;
		String linkTruyen;
		String tenChuong;
		String linkChuong;
		Demo1 d = new Demo1();

		elements = d.getContentFromLink(url, tag);

		for (Element i : elements) {
			theLoaiTruyen = i.html();
			linkTheLoaiTruyen = i.attr("href");
			System.out.println("===========> ten the loai truyen: " + theLoaiTruyen + "\t" + "link the loai truyen: " + linkTheLoaiTruyen + "\n");

			
			Elements truyen = d.getContentFromLink(linkTheLoaiTruyen, "ul li.story-list a.thumb");		
			ArrayList truyenArrayList = new ArrayList<Truyen>();
			for (Element j : truyen) {
				tenTruyen = j.attr("title");
				linkTruyen = j.attr("href");
				System.out.println("ten truyen: " + tenTruyen + "\t" + "link truyen: " + linkTruyen + "\n");
				
				
				Elements chuong = d.getContentFromLink(linkTruyen, "div#chapters ul.chapters li.vip-0 a");
				ArrayList chuongArrayList = new ArrayList<Chuong>();
				for (Element z : chuong) {
					tenChuong = z.html();
					linkChuong = z.attr("href");
					System.out.println("ten chuong: " + tenChuong + "\t" + "link chuong: " + linkChuong + "\n");
					Chuong c = new Chuong(tenChuong, linkChuong);
					chuongArrayList.add(c);
				}
				Truyen t = new Truyen(tenTruyen, linkTruyen, chuongArrayList);
				truyenArrayList.add(t);
				break;
			}
			TheLoaiTruyen tlt = new TheLoaiTruyen(theLoaiTruyen, linkTheLoaiTruyen, truyenArrayList);
			d.writeFileJson(tlt);
			break;
		}

	}
}
