package io.github.gravetii.game;

import io.github.gravetii.pojo.WordResult;
import io.github.gravetii.util.GridPoint;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
  private Map<String, WordResult> wordToResultMap = new LinkedHashMap<>();
  private int totalScore = 0;
  private Quality quality;

  public void put(String word, int score, List<GridPoint> seq) {
    if (!this.wordToResultMap.containsKey(word)) {
      this.wordToResultMap.put(word, new WordResult(word, score, seq));
      this.totalScore += score;
    }
  }

  public boolean exists(String word) {
    return this.wordToResultMap.containsKey(word);
  }

  public int getTotalScore() {
    return this.totalScore;
  }

  public int getPoints(String word) {
    return this.wordToResultMap.get(word).getScore();
  }

  public Map<String, WordResult> all() {
    return this.wordToResultMap;
  }

  public WordResult getWordResult(String word) {
    return this.wordToResultMap.get(word);
  }

  public void defineQuality() {
    for (Quality q : Quality.values()) {
      if (this.wordToResultMap.size() > q.getMinCount()) {
        this.quality = q;
        break;
      }
    }
  }

  public Quality getQuality() {
    return this.quality;
  }

  @Override
  public String toString() {
    return "GameResult{"
        + "wordToResultMap="
        + wordToResultMap
        + ", totalScore="
        + totalScore
        + ", quality="
        + quality
        + '}';
  }
}
