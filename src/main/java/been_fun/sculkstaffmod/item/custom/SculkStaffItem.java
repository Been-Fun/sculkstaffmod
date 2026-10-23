package been_fun.sculkstaffmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class SculkStaffItem extends Item {
    final RandomSource random = RandomSource.create();
    int xpCount = 20 + this.random.nextInt(30) + this.random.nextInt(30);

    public SculkStaffItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(final UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Block block = level.getBlockState(pos).getBlock();
        Vec3 vec3blockpos = Vec3.atCenterOf(pos);


        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }
        if (block == Blocks.BEDROCK) {
            return InteractionResult.FAIL;
        } else {
                level.setBlock(pos, Blocks.SCULK.defaultBlockState(), 0);
                level.destroyBlock(pos, false);

                ExperienceOrb.award((ServerLevel) level, vec3blockpos, xpCount);

                return InteractionResult.SUCCESS;
                }
            }
        }

