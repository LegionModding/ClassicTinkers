package com.legionmodding.classictinkers.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import slimeknights.mantle.block.InventoryBlock;

public class BlockCastingTable extends InventoryBlock
{
    private static final VoxelShape SHAPE = VoxelShapes.join(
            VoxelShapes.block(),
            VoxelShapes.or(
                    Block.box(4.0D, 0.0D, 0.0D, 12.0D, 10.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 4.0D, 16.0D, 10.0D, 12.0D),
                    Block.box(1.0D, 15.0D, 1.0D, 15.0D, 16.0D, 15.0D)
            ), IBooleanFunction.ONLY_FIRST);
    
    public BlockCastingTable()
    {
        super(Block.Properties.of(Material.STONE).strength(3F, 20F));
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
    }
}
