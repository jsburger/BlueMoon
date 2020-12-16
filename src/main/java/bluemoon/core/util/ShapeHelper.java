package bluemoon.core.util;

import bluemoon.core.BlueMoon;
import net.minecraft.util.math.BlockPos;

import java.util.LinkedList;
import java.util.List;

public class ShapeHelper {

    public static List<BlockPos> getHorizontalCircularRegion(BlockPos startPos, float radius) {

        List<BlockPos> list = new LinkedList<>();

        for (float i = -radius; i <= radius; i++) {
            int dx = (int)Math.floor(Math.sqrt(radius*radius - i*i));

            for (int j = -dx; j <= dx; j++) {
                list.add(startPos.add(j, 0, i));
            }
        }

        return list;
    }

}
