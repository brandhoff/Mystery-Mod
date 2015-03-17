package com.CiD.MysteryMod.TecEvolution.GUI;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.GUI.BaseGUI;
import com.CiD.MysteryMod.Network.packet.server.ConverterInputPacket;
import com.CiD.MysteryMod.Network.packet.server.ConverterOutputPacket;
import com.CiD.MysteryMod.Network.packet.server.ConverterResetPacket;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerEnergy;
import com.CiD.MysteryMod.TecEvolution.RFbridge.TileEntityConverter;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;

public class GUIconverter extends BaseGUI{
private TileEntityConverter tile;
private List<ForgeDirection> inputs  = new ArrayList<ForgeDirection>();
private List<ForgeDirection> outputs  = new ArrayList<ForgeDirection>();

private String UP,LEFT,RIGHT,FRONT,BACK,DOWN;
	public GUIconverter(EntityPlayer player, TileEntityEnergy tile) {
		super(new ContainerEnergy(player.inventory, tile));
		this.tile = (TileEntityConverter) tile;
		
		inputs = this.tile.getInputs();
		outputs = this.tile.getOutputs();

		for(ForgeDirection dir : inputs){
			switch(dir){
				case UP:{ this.UP = "I"; break;}
				case DOWN:{ this.DOWN = "I"; break;}
				case EAST:{ this.RIGHT = "I"; break;}
				case WEST:{ this.LEFT = "I"; break;}
				case NORTH:{ this.BACK = "I"; break;}
				case SOUTH:{ this.FRONT = "I"; break;}
			default:
				break;

			}
		}
		
		for(ForgeDirection dir : outputs){
			switch(dir){
				case UP:{ this.UP = "O"; break;}
				case DOWN:{ this.DOWN = "O"; break;}
				case EAST:{ this.RIGHT = "O"; break;}
				case WEST:{ this.LEFT = "O"; break;}
				case NORTH:{ this.BACK = "O"; break;}
				case SOUTH:{ this.FRONT = "O"; break;}
			default:
				break;

			}
		}
	}

		@Override
		public void initGui() {
			buttonList = new ArrayList();
			super.initGui();

			int x = 20;
		    buttonList.add(new GuiButton(2, guiLeft - 40 - x, guiTop + 27, 20, 20, UP));
		    buttonList.add(new GuiButton(3, guiLeft - 60 - x, guiTop + 47, 20, 20, LEFT));
		    buttonList.add(new GuiButton(4, guiLeft - 40 - x, guiTop + 47, 20, 20, FRONT));
		    buttonList.add(new GuiButton(5, guiLeft - 20 - x, guiTop + 47, 20, 20,RIGHT));
		    buttonList.add(new GuiButton(6, guiLeft - 40 - x, guiTop + 67, 20, 20, DOWN));
		    buttonList.add(new GuiButton(7, guiLeft - 20 - x, guiTop + 87, 20, 20, BACK));
		    
		    buttonList.add(new GuiButton(8, 20, 42 - 20, 90, 20, "Base settings"));

		}
	
	  @Override
      public void drawBackScreen(float par1, int par2,
                      int par3) {
		  
		  
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/BaseTecGUI.png"));
              int x = (width - xSize) / 2;
              int y = (height - ySize) / 2;
              this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

      }
      
	  @Override
		protected void actionPerformed(GuiButton button) {
			inputs = this.tile.getInputs();
			outputs = this.tile.getOutputs();
			switch(button.id){
			default:
				break;
				case 1:{
					if(showInfoContex){
						showInfoContex = false;
						break;

					}else{
						showInfoContex = true;
						break;

					}
				}
				
				case 2:{
					if(inputs.contains(ForgeDirection.UP)){
						tile.addToOutput(ForgeDirection.UP);
						this.UP = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.UP));

						break;
					}else if(outputs.contains(ForgeDirection.UP)){
						tile.addToInput(ForgeDirection.UP);
						this.UP = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.UP));

						break;
					}
					tile.addToOutput(ForgeDirection.UP);
					this.UP = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.UP));

					break;
				}
				case 3:{
					if(inputs.contains(ForgeDirection.WEST)){
						tile.addToOutput(ForgeDirection.WEST);
						this.LEFT = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.WEST));

						break;
					}else if(outputs.contains(ForgeDirection.WEST)){
						tile.addToInput(ForgeDirection.WEST);
						this.LEFT = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.WEST));

						break;
					}
					tile.addToOutput(ForgeDirection.WEST);
					this.LEFT = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.WEST));

					break;
				}
				case 4:{
					if(inputs.contains(ForgeDirection.SOUTH)){
						tile.addToOutput(ForgeDirection.SOUTH);
						this.FRONT = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.SOUTH));

						break;
					}else if(outputs.contains(ForgeDirection.SOUTH)){
						tile.addToInput(ForgeDirection.SOUTH);
						this.FRONT = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.SOUTH));

						break;
					}
					tile.addToOutput(ForgeDirection.SOUTH);
					this.FRONT = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.SOUTH));

					break;
				}
				case 5:{
					if(inputs.contains(ForgeDirection.EAST)){
						tile.addToOutput(ForgeDirection.EAST);
						this.RIGHT = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.EAST));

						break;
					}else if(outputs.contains(ForgeDirection.EAST)){
						tile.addToInput(ForgeDirection.EAST);
						this.RIGHT = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.EAST));

						break;
					}
					tile.addToOutput(ForgeDirection.EAST);
					this.RIGHT = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.EAST));

					break;
				}
				case 6:{
					if(inputs.contains(ForgeDirection.DOWN)){
						tile.addToOutput(ForgeDirection.DOWN);
						this.DOWN = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.DOWN));

						break;
					}else if(outputs.contains(ForgeDirection.DOWN)){
						tile.addToInput(ForgeDirection.DOWN);
						this.DOWN = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.DOWN));

						break;
					}
					tile.addToOutput(ForgeDirection.DOWN);
					this.DOWN = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.DOWN));

					break;
				}
				case 7:{
					if(inputs.contains(ForgeDirection.NORTH)){
						tile.addToOutput(ForgeDirection.NORTH);
						this.BACK = "O";
						MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.NORTH));

						break;
					}else if(outputs.contains(ForgeDirection.NORTH)){
						tile.addToInput(ForgeDirection.NORTH);
						this.BACK = "I";
						MysteryMain.packetPipeline.sendToServer(new ConverterInputPacket(tile, ForgeDirection.NORTH));

						break;
					}
					tile.addToOutput(ForgeDirection.NORTH);
					this.BACK = "O";
					MysteryMain.packetPipeline.sendToServer(new ConverterOutputPacket(tile, ForgeDirection.NORTH));

					break;
				}
				case 8:{
					
					
					
					UP= "";
					LEFT= "";
					RIGHT= "";
					FRONT= "";
					BACK= "";
					DOWN= "";
					tile.resetSettings();
					MysteryMain.packetPipeline.sendToServer(new ConverterResetPacket(tile));

					break;
				}
			}
			
		initGui();

		    
		}
	  
	@Override
	public String[] getInfo() {
		String[] s = {"Use this interface to configure inputs and outputs",
				"I stands for input and O for Output",
				"The buttons are aranged like this:",
				"       TOP",
				"WEST SOUTH EAST",
				"       DOWN",
				"             NORTH"};
		return s;
	}
	
	
	@Override		
	/** DONT USE THIS !! USE drawBackScreen*/
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		if(showInfoContex){
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/infoGUI.png"));
	    
	         drawTexturedModalRect(guiLeft, guiTop-40, 0, 0, 256, 256);
	         if(getInfo() != null){
	         String[] text = getInfo();
	         int lineNum = 0;
	         for(String line : text){
	        	 fontRendererObj.drawString(line, guiLeft+4, guiTop+20 + lineNum*10, 0x222222, false);
	        	 lineNum++;

	         }
	        }
	     }else{
	    	 drawBackScreen(f,i,j);
	     }
	
	}

}
