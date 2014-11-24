import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

class Tutorial {
    static final String inputFileName  = "xml-representations/XML-ABBREV.xml";

    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        String queryString =
                "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "select distinct ?film where  {" +
                        "   ?film a dbpedia-owl:Film ;" +
                        "         rdfs:label ?label ." +
                        "   filter regex( ?label, \"Inglourious Basterds\", \"i\")" +
                        "}" +
                        "limit 10";

        // now creating query object
        Query query = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);

        try {
            ResultSet results = qexec.execSelect();

            // Output query results
            ResultSetFormatter.out(System.out, results, query);

            // now write the model in XML form to a file
            model.write(System.out, "RDF/XML-ABBREV");
        }
        finally {
            qexec.close();
        }
    }
}
