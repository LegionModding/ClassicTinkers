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

public class BlockCastingBasin extends InventoryBlock
{
    //TODO Facing & waterlogged

    private static final VoxelShape SHAPE = VoxelShapes.join(
            VoxelShapes.block(),
            VoxelShapes.or(
                    Block.box(0.0D, 0.0D, 5.0D, 16.0D, 2.0D, 11.0D),
                    Block.box(5.0D, 0.0D, 0.0D, 11.0D, 2.0D, 16.0D),
                    Block.box(2.0D, 0.0D, 3.0D, 14.0D, 3.0D, 14.0D),
                    Block.box(7.0D, 5.0D, 0.0D, 9.0D, 13.0D, 16.0D),
                    Block.box(0.0D, 5.0D, 7.0D, 16.0D, 13.0D, 9.0D),
                    Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D)),
            IBooleanFunction.ONLY_FIRST);

    public BlockCastingBasin()
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
