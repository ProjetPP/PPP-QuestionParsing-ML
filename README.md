# PPP-QuestionParsing-ML

This project is a complete reformulation of the Python 3 project PPP-QuestionParsing-ML-standalone.
This work is currently in progress.
Right now, two functions are implemented:

   -feature extraction (build a vector with an english sentence).
   -Loading of the dataset

##Dependancies:
   -StanfordParser: this project uses directly StanfordParser, so you have to download the sources of StanfordParser and to link them to the project in your java IDE.
   -A look up table:

   cd PP-QuestionParsing-ML
   wget http://metaoptimize.s3.amazonaws.com/cw-embeddings-ACL2010/embeddings-scaled.EMBEDDING_SIZE=25.txt.gz
   gzip -d embeddings-scaled.EMBEDDING_SIZE=25.txt.gz
   
   
