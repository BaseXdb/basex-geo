package org.basex.query.func.geo;

import static org.basex.query.func.geo.GeoError.*;

import org.basex.query.QueryContext;
import org.basex.query.QueryException;
import org.basex.query.value.item.Bln;
import org.basex.query.value.item.Item;
import org.basex.util.InputInfo;
import org.basex.util.Token;
import org.basex.util.Util;
import org.locationtech.jts.geom.Geometry;

/**
 * Function implementation.
 *
 * @author BaseX Team, BSD License
 * @author Christian Gruen
 */
public final class GeoRelate extends GeoFn {
  @Override
  public Item item(final QueryContext qc, final InputInfo ii) throws QueryException {
    final Geometry geo1 = toGeometry(0, qc);
    final Geometry geo2 = toGeometry(1, qc);
    final byte[] matrix = toToken(exprs[2], qc);
    try {
      return Bln.get(geo1.relate(geo2, Token.string(matrix)));
    } catch (final IllegalArgumentException ex) {
      Util.debug(ex);
      throw GEO_ARG.get(info, matrix);
    }
  }
}
