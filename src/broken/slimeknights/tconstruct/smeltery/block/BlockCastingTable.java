package com.legionmodding.classictinkers.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import slimeknights.mantle.block.InventoryBlock;

import javax.annotation.Nonnull;
import java.util.Locale;

public class BlockCastingTable extends InventoryBlock implements IFaucetDepth, IWaterLoggable
{


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new TileCastingTable();
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        if(!world.isClientSide)
        {
            if (playerIn.isSneaking())
            {
                return false;
            }

            TileEntity te = worldIn.getTileEntity(pos);

            if (te instanceof TileCasting)
            {
              ((TileCasting) te).interact(playerIn);
              return true;
            }
        }

          return super.use(state, world, pos, player, hand, rayTraceResult);
      }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

          // we have rotation for the stuff too so the items inside rotate according to placement!
          TileEntity te = world.getTileEntity(pos);
          if(te != null && te instanceof TileCasting)
          {
                ((TileCasting) te).setFacing(placer.getHorizontalFacing().getOpposite());
          }
    }

    @Override
    public boolean isSideSolid(@Nonnull IBlockState base_state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
      if(base_state.getValue(TYPE) == CastingType.BASIN) {
        // solid from the sides, but not up and below
        return side != EnumFacing.DOWN;
      }
      return super.isSideSolid(base_state, world, pos, side);
    }

    /* Bounds */
    private static ImmutableList<AxisAlignedBB> BOUNDS_Table = ImmutableList.of(
        new AxisAlignedBB(0, 0.625, 0, 1, 1, 1),
        new AxisAlignedBB(0,    0, 0,    0.25, 0.625, 0.25),
        new AxisAlignedBB(0.75, 0, 0,    1,    0.625, 0.25),
        new AxisAlignedBB(0.75, 0, 0.75, 1,    0.625, 1),
        new AxisAlignedBB(0,    0, 0.75, 0.25, 0.625, 1)
    );
    private static ImmutableList<AxisAlignedBB> BOUNDS_Basin = ImmutableList.of(
        new AxisAlignedBB(0, 0.25, 0, 1, 1, 1),
        new AxisAlignedBB(0,      0, 0,      0.3125, 0.25, 0.3125),
        new AxisAlignedBB(0.6875, 0, 0,      1,      0.25, 0.3125),
        new AxisAlignedBB(0.6875, 0, 0.6875, 1,      0.25, 1),
        new AxisAlignedBB(0,      0, 0.6875, 0.3125, 0.25, 1)
    );

    @Override
    public RayTraceResult collisionRayTrace(IBlockState blockState, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Vec3d start, @Nonnull Vec3d end) {
      if(blockState.getValue(TYPE) == CastingType.BASIN) {
        return BlockTable.raytraceMultiAABB(BOUNDS_Basin, pos, start, end);
      }
      return BlockTable.raytraceMultiAABB(BOUNDS_Table, pos, start, end);
    }

    @Override
    protected boolean openGui(PlayerEntity player, World world, BlockPos pos) {
      // no gui
      return false;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
      return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
      return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos) {
      TileEntity te = world.getTileEntity(pos);
      if(!(te instanceof TileCasting)) {
        return 0;
      }

      return ((TileCasting) te).comparatorStrength();
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, @Nonnull IBlockAccess blockAccess, @Nonnull BlockPos pos, EnumFacing side) {
      return true;
    }

    @Override
    public float getFlowDepth(World world, BlockPos pos, IBlockState state) {
      if(state.getValue(TYPE) == CastingType.TABLE) {
        return 0.125f;
      }
      else {
        return 0.725f;
      }
    }
}
