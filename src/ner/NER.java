/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edistor.
 */
package ner;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.List;

/**
 *
 * @author Yashwant
 */
public class NER {
    public static String[] NER(String text){
        StanfordCoreNLP stanfordCoreNLP= Pipeline.getPipeline();
        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        
        
        List<CoreLabel> coreLabels= coreDocument.tokens();
        String[] List={"","",""};
        
        for(CoreLabel coreLabel:coreLabels){
            String ner=coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            switch(ner){
                case "PERSON":List[0]=List[0]+","+coreLabel.originalText();
                break;
                case "CITY":List[1]=List[1]+","+coreLabel.originalText();
                break;
                case "ORGANIZATION":List[2]=List[2]+","+coreLabel.originalText();
                break;
            }
            
        }
        
        return List;
    }
    
}