package exam;
/*스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
입출력 예
genres	plays	return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Genre {
	private String genre;
	private int play;
	private int id;
	private int max;
	public Genre(String genre, int play, int id) {

		this.genre = genre;
		this.play = play;
		this.id = id;
		
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPlay() {
		return play;
	}

	public void setPlay(int play) {
		this.play = play;
	}

	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Genre [genre=" + genre + ", play=" + play + ", id=" + id + "]";
	}

}

public class BestAlbum {

	public List<Genre> solution(String[] genres, int[] plays) {

		Map<String, Integer> hm = new HashMap<>();
		List<Genre> gen = new ArrayList<>();
		List<Integer> answer=new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {

			gen.add(new Genre(genres[i], plays[i], i));
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
		}

		
		gen.sort((Genre g1, Genre g2) -> {

			if (g1.getGenre().compareTo(g2.getGenre()) == 0) {
				return g2.getPlay() - g1.getPlay();
			}
			return g1.getGenre().compareTo(g2.getGenre());
		});

		for (String genre : hm.keySet()) {
			for (Genre g : gen) {
				if(genre.equals(g.getGenre())) {
					g.setMax(hm.get(genre));
				}
			}	
		}
		gen.sort((Genre g1, Genre g2) ->g2.getMax()-g1.getMax());
		
		int count=0;
		String prev="";
		for (Genre g: gen ) {
			if(count!=2 &&!g.getGenre().equals(prev)) {
				answer.add(g.getId());
				count++;
			}
			
			
			
			
	}

		
		return gen;
	}

}
