from com.tw import FrequencyCount
import nltk
from nltk import probability
from nltk import corpus
from nltk import stem
from nltk import tokenize

class FrequencyCount(FrequencyCount):
    def buildFreqMap(self, text):
        freq_dict = probability.FreqDist()
        tokens = self.tokenize(text)
        stop_words_removed = self.remove_stop_words(tokens)
        for word in self.stem_text(stop_words_removed):
            freq_dict.inc(word.lower())
        return freq_dict

    def tokenize(self, text):
        all_tokens = tokenize.word_tokenize(text)
        return [w.lower() for w in all_tokens if w.isalpha()]

    def remove_stop_words(self, word_list):
        stop_words = corpus.stopwords.words('english')
        return [w for w in word_list if w.lower() not in stop_words]

    def stem_text(self, word_list):
        after_stem = []
        stemmer = stem.PorterStemmer()
        for w in word_list:
            after_stem.append(stemmer.stem(w))
        return after_stem


  