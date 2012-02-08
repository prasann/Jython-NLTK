from com.tw import FrequencyCount
import nltk
from nltk.probability import FreqDist
from nltk.corpus import stopwords
from nltk import tokenize

class FrequencyCount(FrequencyCount):
    def buildFreqMap(self, text):
        freq_dict = FreqDist()
        tokens = self.tokenize(text)
        for word in self.remove_stop_words(tokens):
            freq_dict.inc(word.lower())
        return freq_dict

    def remove_stop_words(self, word_list):
        stop_words = stopwords.words('english')
        return [w for w in word_list if w.lower() not in stop_words]

    def tokenize(self,text):
        all_tokens = tokenize.word_tokenize(text)
        return [w.lower() for w in all_tokens if w.isalpha()]


  