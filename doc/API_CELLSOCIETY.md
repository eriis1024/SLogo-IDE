Erik Riis (evr4), Dorian Barber (dpb20), Jing Yang (jy201), Kelley Scroggs (jks38)

API Critique

Simulation:
 * Internal - Contains the data and logic to run the simulations. 
    * Cell abstract class and subclasses
    * StyleFactory
    * Grid abstract class and subclasses
    * Neighborhood abstract and subclasses
    * NeighborhoodFactory and subclass
    * Ruleset abstract and subclasses
    * NeighborManager abstract and subclasses
    
* External - Transfer data to XML. 
    * GridtoXMLConverter
    * Engine

Configuration

* Internal - Parses XML files to store initial configuration. 
    * XMLDataFactory
    * XMLException
    * XMLParser
* External - Passes configuration specifications, and takes in data to write XML files. 
    * XMLData abstract class and subclasses
    * XMLParsing
    * FileController and XMLWriter

Visualization

* Internal - Preparing for visualizations. 
    * CurrentSimulation
    * ShapeHandler abstract and subclasses
* External - Shows the visualizations
    * ColorMapper
    * ShapeFactory
    * SimulationCellPanel
    * SimulationControlPanel
    * SimulationGraphPanel
    * Screen abstract and subclasses
    * SimulationSettingsPanel
Not Part of the API
* StandardGrid


