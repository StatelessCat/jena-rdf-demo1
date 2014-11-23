import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.VCARD;

class Tutorial01 {
    // some definitions
    static String personURI    = "http://somewhere/RaphaelCazenaveLeveque";
    static String givenName    = "Raphael";
    static String familyName   = "Cazenave-Leveque";
    static String fullName     = givenName + " " + familyName;

    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        Resource raphaelCazenaveLeveque =
                model.createResource(personURI)
                        .addProperty(VCARD.FN, fullName)
                        .addProperty(VCARD.N,
                                model.createResource() // blank node
                                        .addProperty(VCARD.Given, givenName)
                                        .addProperty(VCARD.Family, familyName));

        // now write the model in XML form to a file
        model.write(System.out);

        // now write the model in XML form to a file
        model.write(System.out, "RDF/XML-ABBREV");

        // now write the model in N-TRIPLES form to a file
        model.write(System.out, "N-TRIPLES");
    }
}
