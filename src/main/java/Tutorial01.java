import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;

class Tutorial01 {
    // some definitions
    static String personURI    = "http://somewhere/RaphaelCazenaveLeveque";
    static String fullName     = "Raphael Cazenave-Leveque";

    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        Resource raphaelCazenaveLeveque = model.createResource(personURI);

        // add the property
        raphaelCazenaveLeveque.addProperty(VCARD.N, fullName);

        // show a representation of this model
        System.out.println(model);
    }
}
