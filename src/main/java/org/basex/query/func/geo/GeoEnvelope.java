package org.basex.query.func.geo;

import org.basex.query.QueryContext;
import org.basex.query.QueryException;
import org.basex.query.value.item.Item;
import org.basex.query.value.node.GNode;
import org.basex.util.InputInfo;

/**
 * Function implementation.
 *
 * @author BaseX Team, BSD License
 * @author Christian Gruen
 */
public final class GeoEnvelope extends GeoFn {
  @Override
  public Item item(final QueryContext qc, final InputInfo ii) throws QueryException {
    final GNode elem = toElem(exprs[0], qc);
    return toElement(toGeometry(elem).getEnvelope(), elem);
  }
}
