# PPP-QuestionParsing-ML

This project is a complete reformulation of the Python 3 project PPP-QuestionParsing-ML-standalone.
This work is currently in progress.
Right now, two functions are implemented:

* feature extraction (build a vector with an english sentence).
* Loading of the dataset

## Dependencies:

* StanfordParser: this project uses directly the StanfordParser, so you have to download the sources of StanfordParser and to link them in your java IDE to the project.
* A look up table: `curl http://metaoptimize.s3.amazonaws.com/cw-embeddings-ACL2010/embeddings-scaled.EMBEDDING_SIZE=25.txt.gz | gunzip > embeddings-scaled.EMBEDDING_SIZE=25.txt`
