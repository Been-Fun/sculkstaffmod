package been_fun.sculkstaffmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3fc;

public class WindStaffItem extends Item {

    public WindStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }


        WindCharge windCharge = new WindCharge(EntityTypes.WIND_CHARGE, level);
        windCharge.setPos(player.position());
        windCharge.setDeltaMovement(0, -5, 0);
        level.addFreshEntity(windCharge);

        WindCharge windCharge1 = new WindCharge(EntityTypes.WIND_CHARGE, level);
        windCharge1.setPos(player.position());
        windCharge1.setDeltaMovement(0, -5, 0);
        level.addFreshEntity(windCharge1);

        WindCharge windCharge2 = new WindCharge(EntityTypes.WIND_CHARGE, level);
        windCharge1.setPos(player.position());
        windCharge1.setDeltaMovement(0, -5, 0);
        level.addFreshEntity(windCharge2);

        WindCharge windCharge3 = new WindCharge(EntityTypes.WIND_CHARGE, level);
        windCharge1.setPos(player.position());
        windCharge1.setDeltaMovement(0, -5, 0);
        level.addFreshEntity(windCharge3);

        WindCharge windCharge4 = new WindCharge(EntityTypes.WIND_CHARGE, level);
        windCharge1.setPos(player.position());
        windCharge1.setDeltaMovement(0, -5, 0);
        level.addFreshEntity(windCharge4);

        return InteractionResult.SUCCESS;
    }
}