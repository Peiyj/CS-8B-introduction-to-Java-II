Describe how polymorphism and dynamic binding was used in Part 1.


Polymorphism is when a superclass object refers to a subclass object. Dynamic binding is when a method can be implemented in several classes along the inheritance chain. In this case, all the Game Tile[emailID] classes are the subclasses of the superclass--GameTile. Polymorphism happens when we designated Game Tile object to be one of the subclasses using the combination of GameTile tile = new GameTile[emailID]() and GameTileFactory functionality. These subclasses all inherite the accessible methods and fields from the Game Tile superclass. This is evident when we call the superclass constructor via super() in GameTile[emailID] class.




Describe the ways in which your moveXXX() code was overly complicated before your refactor.  How did your code style improve after the refactor?  Finally, what you have learned about the process of refactoring code and redesigning features.   


My moveUp(), moveRight(), moveLeft() were too overly complicated because they all repeated the content of moveDown() method. As a result, it made it very difficult for me to debug very method and made it extremely hard for me to read. Moreover, many of the content could be simplified by just retaining the moveDown() method and write a helper method called rotate(). Refractionation definitely helped simplify the method by getting rid of the excessive repetitive content. After this experience, I learn to write helper method instead of a big chunk of complicated code which will make it easy for me to debug and make it more comprehensive.