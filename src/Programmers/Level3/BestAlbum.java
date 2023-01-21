package Programmers.Level3;

import java.util.*;

// 베스트앨범
class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playInfo = new HashMap<>();
        Map<String, List<Music>> musicInfo = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            String gen = genres[i];
            int play = plays[i];
            playInfo.put(gen, playInfo.getOrDefault(gen, 0) + play);

            Music music = new Music(play, i);
            List<Music> musics = musicInfo.getOrDefault(gen, new ArrayList<>());
            musics.add(music);
            musicInfo.put(gen, musics);
        }

        List<Integer> results = new ArrayList<>();

        // 1. 많이 재생된 장르 
        List<String> key = new ArrayList<>(playInfo.keySet());
        key.sort((o1, o2) -> playInfo.get(o2) - playInfo.get(o1));

        for (String gen : key) {
            List<Music> musics = musicInfo.get(gen);

            // 곡이 하나라면 하나만 선택.
            if (musics.size() == 1) {
                results.add(musics.get(0).idx);
                continue;
            }

            // 2. 장르 내에서 많이 재생된 노래
            // 3. 재생 횟수가 동일하면 고유 번호가 낮은 노래
            musics.sort((o1, o2) -> {
                if (o1.play == o2.play) {
                    return o1.idx - o2.idx;
                }
                return o2.play - o1.play;
            });

            results.add(musics.get(0).idx);
            results.add(musics.get(1).idx);
        }

        int[] answer = new int[results.size()];
        int ansIdx = 0;
        for (Integer result : results) {
            answer[ansIdx++] = result;
        }
        return answer;
    }

    static class Music {
        int play;
        int idx;

        public Music(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
}