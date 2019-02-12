package exam;
/*��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.

���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
�뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���ѻ���
genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
�帣 ������ 100�� �̸��Դϴ�.
�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
����� ��
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