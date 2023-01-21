package Programmers.Level2;

// 방금 그 곡
class JustThatSong {
    private static final int MINUTE = 60;
    private static final String NONE = "(None)";

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int ansTime = 0;

        for (String music : musicinfos) {
            String[] info = music.split(",");
            String startTime = info[0];
            String endTime = info[1];

            String title = info[2];
            String melody = info[3];

            int musicTime = makeMinute(endTime) - makeMinute(startTime);
            String fullMelody = makeFullMelody(musicTime, melody);

            // 주어진 멜로디보다 짧으면 애초에 답이 될 수 없으니까 패스.
            m = preprocess(m);
            if (fullMelody.length() < m.length()) {
                continue;
            }

            if(!fullMelody.contains(m)) {
                continue;
            }

            // 재생 시간이 가장 긴 음악을 먼저 반환
            if (ansTime < musicTime) {
                answer = title;
                ansTime = musicTime;
            }
        }

        if (answer.equals("")) {
            return NONE;
        }

        return answer;
    }

    private int makeMinute(String time) {
        String[] timeInfo = time.split(":");
        int hour = Integer.parseInt(timeInfo[0]);
        int minute = Integer.parseInt(timeInfo[1]);

        return hour * MINUTE + minute;
    }

    private String makeFullMelody(int time, String melody) {
        // 멜로디에 대한 전처리 진행
        melody = preprocess(melody);

        // 멜로디 길이
        int melodyLen = melody.length();

        // 멜로디 길이가 재생 시간이랑 같으면 그대로.
        if (melodyLen == time) {
            return melody;
        }

        // 더 길면 잘라서 리턴.
        if (melodyLen > time) {
            return melody.substring(0, time);
        }

        // 더 짧으면 전체 멜로디 생성해주기.
        StringBuilder newMelody = new StringBuilder(melody);
        while(newMelody.length() < time) {
            newMelody.append(melody);
        }

        // 같아지도록 전처리
        if (newMelody.length() != time) {
            newMelody.delete(time, newMelody.length());
        }

        return newMelody.toString();
    }

    private String preprocess(String melody) {
        // 멜로디에 대한 전처리
        return melody.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
}