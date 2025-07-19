package game.meta;

/**
 * Utility class containing the definitions of all Tetris tetromino shapes and their rotations.
 */
public final class Tetrominoes {
    
    /**
     * Private constructor to prevent instantiation.
     */
    private Tetrominoes() {
    }
    
    /**
     * 4D array containing all tetromino shapes and their rotation states.
     * The structure is: [shape][rotation][row][column].
     * Each inner 2D array represents a rotation of a tetromino, where 1 indicates a filled cell.
     */
    protected static final int[][][][] SHAPES = { 
            { // O
                { 
                    { 1, 1 },					
                    { 1, 1 } 
                } 
            }			
            , 			
            {  // I
                {
                    { 0, 1, 0, 0 },					
                    { 0, 1, 0, 0 },					
                    { 0, 1, 0, 0 },					
                    { 0, 1, 0, 0 }
                }
                ,
                {
                    { 0, 0, 0, 0 },
                    { 1, 1, 1, 1 },
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 0 }								
                },
                {
                    { 0, 0, 1, 0 },					
                    { 0, 0, 1, 0 },					
                    { 0, 0, 1, 0 },					
                    { 0, 0, 1, 0 }
                },
                {
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 0 },
                    { 1, 1, 1, 1 },
                    { 0, 0, 0, 0 }								
                }
            }			
            ,			
            { // Z
                { 
                    { 1, 1, 0 },					
                    { 0, 1, 1 },
                    { 0, 0, 0 }
                }
                ,
                { 
                    { 0, 1, 0 },					
                    { 1, 1, 0 },					
                    { 1, 0, 0 }
                }
            }			
            ,			
            { // S
                { 					
                    { 0, 1, 1 },
                    { 1, 1, 0 },
                    { 0, 0, 0 }
                }
                ,				
                { 
                    { 1, 0, 0 },					
                    { 1, 1, 0 },					
                    { 0, 1, 0 }
                }
            }			
            ,			
            { // J
                {					
                    { 0, 0, 1 },					
                    { 0, 0, 1 },					
                    { 0, 1, 1 },					
                }
                ,
                { 
                    { 1, 0, 0 },					
                    { 1, 1, 1 },	
                    { 0, 0, 0 }
                }
                ,
                { 
                    { 0, 1, 1 },					
                    { 0, 1, 0 },					
                    { 0, 1, 0 },					
                }
                ,
                { 
                    { 1, 1, 1 },					
                    { 0, 0, 1 },	
                    { 0, 0, 0 }
                }
            }			
            ,			
            { // L
                {					
                    { 0, 1, 0 },					
                    { 0, 1, 0 },					
                    { 0, 1, 1 },					
                }
                ,
                { 					
                    { 1, 1, 1 },					
                    { 1, 0, 0 },	
                    { 0, 0, 0 }
                }
                ,
                { 
                    { 0, 1, 1 },					
                    { 0, 0, 1 },
                    { 0, 0, 1 }
                }
                ,
                { 					
                    { 0, 0, 1 },
                    { 1, 1, 1 },
                    { 0, 0, 0 }
                }
            } 
            
            ,			
            { // T
                { 
                    { 1, 1, 1 },					
                    { 0, 1, 0 },
                    { 0, 0, 0 }
                }
                ,
                { 					
                    { 0, 0, 1 },
                    { 0, 1, 1 },
                    { 0, 0, 1 }
                }
                ,
                {				
                    { 0, 0, 0 },
                    { 0, 1, 0 },					
                    { 1, 1, 1 }				
                }
                ,
                { 					
                    { 1, 0, 0 },					
                    { 1, 1, 0 },	
                    { 1, 0, 0 }
                }
            } 
        };    
    
    /**
     * Returns a clone of the tetromino shapes array.
     *
     * @return a clone of the 4D array containing all tetromino shapes and their rotations
     */
    public static int[][][][] getShapes() {
        return SHAPES.clone();
    }
}