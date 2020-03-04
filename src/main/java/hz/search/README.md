Example showing Indexed text search with Jet

Searches the directory /books
Ignores words in Stopwords.txt

Usage:

hz.search.TfIdf /Users/sharathsahadevan/eclipse-workspace/hz/src/main/resources/books /Users/sharathsahadevan/eclipse-workspace/hz/src/main/resources/books/stopwords.txt



/**
 * Builds, for a given set of text documents, an <em>inverted index</em>
 * that maps each word to the set of documents that contain it. It assigns
 * to each document in the set a TF-IDF score which tells how relevant the
 * document is to the search term. In short,
 * <ul><li>
 *     {@code TF(document, word)} is <em>term frequency</em>: the number of
 *     occurrences of a given word in a given document. {@code TF} is expected
 *     to correlate with the relevance of the word to the document.
 * </li><li>
 *     Let {@code DF(word)} be the <em>document frequency</em> of a word: the
 *     number of documents a given word occurs in.
 * </li><li>
 *     {@code IDF(word)} is the <em>inverse document frequency</em> of a word:
 *     {@code log(D/DF)} where {@code D} is the overall number of documents.
 *     IDF is expected to correlate with the salience of the word: a high value
 *     means it's highly specific to the documents it occurs in. For example,
 *     words like "in" and "the" have an IDF of zero because they occur
 *     everywhere.
 * </li><li>
 *     {@code TF-IDF(document, word)} is the product of {@code TF * IDF} for a
 *     given word in a given document.
 * </li><li>
 *     A word that occurs in all documents has an IDF score of zero, therefore
 *     its TF-IDF score is also zero for any document. Such words are called
 *     <em>stopwords</em> and can be eliminated both from the inverted index and
 *     from the search phrase as an optimization.
 * </li></ul>
 * When you run the program, it will first spend a couple of seconds
 * building the inverted index using Hazelcast Jet and then a GUI window
 * will show up where you can use the index to perform text searches over
 * the documents.
 * <p>
 * When you enter a search phrase, the program first crosses out the
 * stopwords, then looks up each remaining search term in the inverted
 * index, resulting in a set of documents for each search term. It takes an
 * intersection of all these sets, which gives us only the documents that
 * contain all the search terms. For each combination of document and search
 * term there will be an associated TF-IDF score. It sums up these scores
 * per document to retrieve the total score of each document. Finally, it
 * sorts the list of documents by score (descending) and presents them to
 * the user as the search result.
 **/