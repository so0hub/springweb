package example.day12.웹크롤링;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrawlingService {

    // [1] Jsoup 이용한 특정 url html 정보 수집
    public List<String> test1(){
        List<String> list = new ArrayList<>(); // 여러개 문자열 저장 리스트;
        // 1) 크롤링 URL 웹페이지 주소
        String url = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";
        // 2) 크롤링할 URL 요청하여 HTML 전체를 가져온다. Jsoup.connect( 주소 ).get();
        // Document , import.org.Jsoup.nodes.Document;
        try {
            Document document = Jsoup.connect(url).get(); // 외부 통신은 일반예외 주로 발생
            System.out.println("document = " + document);
        // 3) 특정한 마크업/요소 식별자 , document.select("식별자")
            Elements elements = document.select(".titles > a"); // 클래스가 titles 인 마크업 아래에 <a> 가져온다.
            System.out.println("elements = " + elements);
        // 4) 여러개 가져왔다면 반복문 이용한 요소/마크업(Element) 1개씩 순회
            for( Element element : elements ){
                String title = element.text(); // vs innetHTML 비슷하게 마크업 사이 텍스트를 반환 <a> 여기! </a>
                // 만약에 텍스트가 존재하면 리스트에 담기
                if(title.isBlank()){continue;} // 반복문 위로 이동
                else{ list.add(title);}
            }
        }catch ( Exception e ){System.out.println(e);}
        return list;
    } // f END

    // [2] Jsoup 이용한 HTML 정보 수집 , 페이지이동
    public List<Map<String, Object>> test2(){
        List<Map<String,Object>> list = new ArrayList<>(); // 책정보(dto/map)들을 담는 리스트 선언
        try{
            for( int page = 1 ; page <= 3 ; page++ ) { // page는 1부터 3까지
                // 1) 크롤링 URL 주소 ( 예스24 베스트셀러 일별 ) ++ 반복문 이용하여 페이지 번호 여러개 요청
                String url = "https://www.yes24.com/product/category/daybestseller";
                url += "?categoryNumber=001;"; // 베스트셀러 카테고리 번호
                url += "&pageNumber=" + page; // 크롤링할 페이지 번호 <page 변수로 활용>
                url += "&pageSize=24"; // 페이지당 제품 수
                // 2) 페이지 연결
                Document document = Jsoup.connect(url).get();
                // 3) 식별자 , 가져올 텍스트가 위치한 식별자와 상위 식별자 1~2 같이 선택한다. < 중복 배제 >
                Elements nameList = document.select(".info_name .gd_name"); // 책이름 , .info_name .gd_name
                Elements priceList = document.select(".info_price .txt_num .yes_b"); // 책가격 , .info_price .txt_num .yes_b
                Elements imageList = document.select(".img_bdr .lazy"); // 책이미지 , .img_bdr .lazy
                // 4) 반복문 이용하여 여러개 요소/마크업들을 도서별 MAP 구성하여 LIST 저장
                for(int index = 0 ; index < nameList.size() ; index++ ){ // 첫번째 도서부터 마지막 도서까지
                    String name = nameList.get( index ).text(); // index번째 요소의 책이름(텍스트) 반환
                    String price = priceList.get( index ).text();
                    // text() : 마크업 사이 텍스트 반환 , attr(속성명) : 해당 속성명의 속성값
                    String image = imageList.get( index ).attr("data-original");
                    // 5) DTO/MAP 구성
                    Map<String , Object> map = new HashMap<>();
                    map.put("name",name); map.put("price",price); map.put("image",image);
                    // 6)
                    list.add(map);

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list; // 리스트 반환
    } // f END
} // c END

// 웹크롤링 : 웹(페이지의) HTML 정보/자료 수집 과정
// 웹페이지 마다 크롤링 허용 여부 : URL?robots.txt
// https://www.jobkorea.co.kr/robots.txt
// 정적페이지 : HTML ,   동적페이지 : JS( AXIOS/REACT )
// 정적페이지 : Jsoup 라이브러리
// 동적페이지 : selenium 라이브러리 ( * 파이썬 동일 )

// - Jsoup 라이브러리 : implementation 'org.jsoup:jsoup:1.22.1'