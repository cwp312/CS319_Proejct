package main.gmm;

import main.EntityGrid;
import main.GraphicGrid;
import main.RenderData;

public class GraphicsAssembler {
	
	public RenderData render(GraphicGrid gfx, EntityGrid entities) {
		//TODO(Someone) Finish implementation
		RenderData data = new RenderData();
		
		data.setBackground(gfx.getTiles());
		
		data.addForeground(entities.getPlayer().getGraphic());
		data.addCoordinateX(entities.getPlayer().getXLoc());
		data.addCoordinateY(entities.getPlayer().getYLoc());
		
		if(entities.getData().size() > 0) {
			int offset = 1;
			
			for(int i = 0; i < entities.getData().size(); i++) {
			
			}
		}
		
		return data;
	}

}
