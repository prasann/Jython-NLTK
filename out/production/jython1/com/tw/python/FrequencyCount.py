from com.tw import FrequencyCount
import nltk
from nltk.probability import FreqDist
from nltk import tokenize

class FrequencyCount(FrequencyCount):
    def buildFreqMap(self, text):
        freq = FreqDist()
        for word in tokenize.word_tokenize(text):
            freq.inc(word.lower())
        return freq
  